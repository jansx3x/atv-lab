class Sala {

    constructor() {
        this._alunos = [];
    }

    adiciona(aluno ) {
        this._alunos.push(aluno );
    }

    get itens() {
        return [].concat(this._alunos);
    }
}