let mysql = require('mysql');

// solução 03: Usando classes
class ConnectionFactory {

    constructor() {
        this._conexao = mysql.createConnection({
          
            host: 'localhost',
            user: 'root',
            password: '1234',
            database: 'musica'
        });
    }


    getConexao() {
        return this._conexao;
    }

}

module.exports = () => { return ConnectionFactory };