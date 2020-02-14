package com.lpweb.lojamusical.repository.album;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.repository.filter.AlbumFiltro;

public class AlbumRepositoryImpl implements AlbumRepositoryQuery{

	@PersistenceContext
    private EntityManager manager;
	
	@Override
	public Page<Album> filtrar(AlbumFiltro filtro, Pageable pageable) {

		CriteriaBuilder cBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Album> cQuery = cBuilder.createQuery(Album.class );

        Root<Album> albumRoot = cQuery.from(Album.class );

        Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, albumRoot  );


        cQuery.select(albumRoot)
              .where(restricoes )
              .orderBy( cBuilder.desc(albumRoot.get("nome")) );

        TypedQuery<Album> query = manager.createQuery(cQuery);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<Album>(query.getResultList(), pageable, total(filtro) );
	}


	    private Predicate[] criaRestricoes(AlbumFiltro filtro, CriteriaBuilder cBuilder, Root<Album> albumRoot) {

	        List<Predicate> predicates = new ArrayList<>();

	        if ( !StringUtils.isEmpty( filtro.getNome()) ) {
	        	
	            predicates.add(cBuilder.like(cBuilder.lower(albumRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%" ) );

	        }

	        if ( Objects.nonNull(filtro.getAno()) ) {
	            predicates.add( cBuilder.ge( albumRoot.get("ano"), filtro.getAno() ));
	        }

	        if (Objects.nonNull(filtro.getArtistaId()) ) {

	            Path<Integer> categoriaPath = albumRoot.join("artistas").<Integer>get("id");
	
	            predicates.add ( cBuilder.equal(categoriaPath, filtro.getArtistaId() ) );
			
	        }

	        return predicates.toArray(new Predicate[ predicates.size() ] );
	    }



	    private void adicionaRestricoesDePaginacao(TypedQuery<Album> query, Pageable pageable) {
	        Integer paginaAtual = pageable.getPageNumber();
	        Integer totalObjetosPorPagina = pageable.getPageSize();
	        Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

	        // 0 a n-1, n - (2n -1), ...
	        query.setFirstResult(primeiroObjetoDaPagina );
	        query.setMaxResults(totalObjetosPorPagina );

	    }

	    private Long total(AlbumFiltro filtro) {
	        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
	        CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

	        Root<Album> rootProduto = cQuery.from(Album.class);

	        Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootProduto);

	        cQuery.where(predicates );
	        cQuery.select( cBuilder.count(rootProduto) );

	        return manager.createQuery(cQuery).getSingleResult();
	    }
}
