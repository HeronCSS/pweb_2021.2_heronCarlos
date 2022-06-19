function cargosList(element) {
    $(
        `<option value="${element.id}" class="option">${element.nome}</option>`
    ).insertBefore(".option");
}


$("#list-produtos").change(function () {
    const idProd = $(this).prop('value');
    console.log(idProd);
    var requestURL = '/api/produtos/' + idProd;
    var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.responseType = 'json';
    request.send();
    request.onload = function () {
        console.log(request.response);
        if (request.response.length != 0) {
            $("#list-produtos").attr("disabled", false);
            $("#div-prod-pedido").toggle(true);
            $("#nome-produto").text(request.response.nomeProduto);
            $("#marca-produto").text(request.response.marca);
            $("#altura-produto").text(request.response.altura);
            $("#largura-produto").text(request.response.largura);
            $("#profundidade-produto").text(request.response.profundidade);
            $("#volume-produto").text(request.response.volume);
            $("#peso-produto").text(request.response.peso);
            $("#preco-produto").text(request.response.precoVenda);
            $("#img-produto").attr("src", request.response.linkImg);
        } else {
            $("#boxAtribuicaoCargo").toggle(false);
            $("#nome-produto").text("Selecione o Produto para ver informações");
        }
    }
})

document.getElementById('select').addEventListener('click', function(){
    if(document.getElementById('select').value == document.getElementById('option-1').value){
        document.getElementById('divCartao').style.display = 'block';
        document.getElementById('divBanco').style.display = 'none';
    } else if (document.getElementById('select').value == document.getElementById('option-2').value){
        document.getElementById('divCartao').style.display = 'none';
        document.getElementById('divBanco').style.display = 'none';
    }
    
    else {
        document.getElementById('divCartao').style.display = 'none';
        document.getElementById('divBanco').style.display = 'block';
    }
})