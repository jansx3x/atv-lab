class Aluno {

    constructor(nome, nota1, nota2, frequencia, final){
        this._nome = nome;
        this._nota1 = nota1;
        this._nota2 = nota2;
        this._frequencia = frequencia;
        this._final = final;

        Object.freeze(this );
    }

    get media() {
        return (this._nota1 + this._nota2) / 2;
    }

    get nome(){
        return this._nome;
    }

    get nota1() {
        return this._nota1;
    }

    get nota2() {
        return this._nota2;
    }

    get frequencia(){
        return this._frequencia
    }

    get final() {
        return this._final;
    }
}