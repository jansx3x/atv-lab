class SalaController{

    constructor() {

        let $ = document.querySelector.bind(document);

        this._inputNome = $('#nome');
        this._inputNota1 = $('#nota1');
        this._inputNota2 = $('#nota2');
        this._inputFreq = $('#frequencia');

        this._sala = new Sala();
    }

    adiciona(event ) {

        event.preventDefault();

        let aluno = this._criaAluno();
    }

    _criaAluno() {
        return new Aluno(
            this._inputNome.value, 
            this._inputNota1.value, 
            this._inputNota2.value,
            this._inputFreq.value);
    }
}