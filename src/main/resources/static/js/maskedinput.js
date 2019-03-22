/**
 * Máscara para CPF e CNPJ - Fornecedor
 */

var cpfCnpj= $("#cpfCnpj").val().length;
 
    if(cnpjcpf < 11){
        $("#cpfCnpj").mask("999.999.999-99");
    } else {
        $("#cpfCnpj").mask("99.999.999/9999-99");
    }    