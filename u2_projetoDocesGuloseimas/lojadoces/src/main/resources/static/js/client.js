function paginaCadastrar() {
    if (document.getElementById('divCadastrar').style.display == 'none') {
        document.getElementById('listarClientes').style.display = 'none';
        document.getElementById('divCadastrarNovo').style.display = 'none';
        document.getElementById('divCadastrar').style.display = 'block';
    }

}

function cancelar() {
    if (document.getElementById('divCadastrar').style.display == 'block') {
        document.getElementById('divCadastrar').style.display = 'none';
        document.getElementById('listarClientes').style.display = 'block'
        document.getElementById('divCadastrarNovo').style.display = 'block';
    }
}
function juntarDDD() {
    var numero = document.getElementById('telefone');
    var num = document.getElementById('ddd');
    var tot = '(' + num.value + ') ' + numero.value;
    if (tot.length == 12) {
        var tot2 = tot.slice(0, 8) + "-" + tot.slice(8);
        document.getElementById('juncao').value = tot2;
        console.log(document.getElementById('juncao').value)
    } if (tot.length == 14 && !tot.includes('-')) {
        var tot2 = tot.slice(0, 10) + "-" + tot.slice(10);
        document.getElementById('juncao').value = tot2;
        console.log(document.getElementById('juncao').value)
    }
}

var btn = document.getElementsByClassName('nav-item');

btn[0].addEventListener('mouseover', function () {
    btn[0].style.marginLeft = '0%'
    btn[0].style.marginRight = '10%'
    document.getElementsByClassName('active')[0].style.marginRight = '0%';
    document.getElementsByClassName('active')[0].style.marginLeft = '0%';
});
btn[0].addEventListener('mouseout', function () {
    btn[0].style.margin = '0%';
    document.getElementsByClassName('active')[0].style.marginRight = '5%';
    document.getElementsByClassName('active')[0].style.marginLeft = '5%';
});

btn[2].addEventListener('mouseover', function () {
    btn[2].style.marginLeft = '15%'
    btn[2].style.marginRight = '5%'
    document.getElementsByClassName('active')[0].style.marginRight = '0%';
    document.getElementsByClassName('active')[0].style.marginLeft = '0%';
});
btn[2].addEventListener('mouseout', function () {
    btn[2].style.margin = '0%';
    document.getElementsByClassName('active')[0].style.marginRight = '5%';
    document.getElementsByClassName('active')[0].style.marginLeft = '5%';
});

//
btn[3].addEventListener('mouseover', function () {
    btn[3].style.marginLeft = '15%'
    btn[3].style.marginRight = '5%'
    document.getElementsByClassName('active')[0].style.marginRight = '0%';
    document.getElementsByClassName('active')[0].style.marginLeft = '0%';
});
btn[3].addEventListener('mouseout', function () {
    btn[3].style.margin = '0%';
    document.getElementsByClassName('active')[0].style.marginRight = '5%';
    document.getElementsByClassName('active')[0].style.marginLeft = '5%';
});

//
btn[4].addEventListener('mouseover', function () {
    btn[4].style.marginLeft = '15%'
    btn[4].style.marginRight = '5%'
    document.getElementsByClassName('active')[0].style.marginRight = '0%';
    document.getElementsByClassName('active')[0].style.marginLeft = '0%';
});
btn[4].addEventListener('mouseout', function () {
    btn[4].style.margin = '0%';
    document.getElementsByClassName('active')[0].style.marginRight = '5%';
    document.getElementsByClassName('active')[0].style.marginLeft = '5%';
});

//
btn[5].addEventListener('mouseover', function () {
    btn[5].style.marginLeft = '15%'
    btn[5].style.marginRight = '5%'
    document.getElementsByClassName('active')[0].style.marginRight = '0%';
    document.getElementsByClassName('active')[0].style.marginLeft = '0%';
});
btn[5].addEventListener('mouseout', function () {
    btn[5].style.margin = '0%';
    document.getElementsByClassName('active')[0].style.marginRight = '5%';
    document.getElementsByClassName('active')[0].style.marginLeft = '5%';
});

/*<![CDATA[*/
const dateNascimento = /*[[${cliente.dataNascimento}]]*/ 'default';
var d = new Date(dateNascimento);
var today = new Date(dateNascimento).toISOString().slice(0, 10);
document.getElementById('cliente-dataNascimento').value = today;    



/*]]>*/

function editarCliente() {
    if (document.getElementById('cliente-nome').disabled == true) {
        document.getElementById('cliente-nome').disabled = false;
        document.getElementById('cliente-dataNascimento').disabled = false;
        document.getElementById('cliente-cpf').disabled = false;
        document.getElementById('cliente-celular').disabled = false;
        document.getElementById('cliente-email').disabled = false;
        document.getElementById('cliente-genero').disabled = false;
        document.getElementById('botao-cliente').innerText = 'Cancelar';
        document.getElementById('botao-cliente-salvar').hidden = false;
    } else {
        document.getElementById('cliente-nome').disabled = true;
        document.getElementById('cliente-dataNascimento').disabled = true;
        document.getElementById('cliente-cpf').disabled = true;
        document.getElementById('cliente-celular').disabled = true;
        document.getElementById('cliente-email').disabled = true;
        document.getElementById('cliente-genero').disabled = true;
        document.getElementById('botao-cliente').innerText = 'Editar';
        document.getElementById('botao-cliente-salvar').hidden = true;
    }
}
function editarEndereco() {
    if (document.getElementById('endereco-rua').disabled == true) {
        document.getElementById('endereco-rua').disabled = false;
        document.getElementById('endereco-numero').disabled = false;
        document.getElementById('endereco-complemento').disabled = false;
        document.getElementById('endereco-cep').disabled = false;
        document.getElementById('endereco-cidade').disabled = false;
        document.getElementById('endereco-uf').disabled = false;
        document.getElementById('btn-endereco').innerText = 'Cancelar';
        document.getElementById('botao-endereco-salvar').hidden = false;
    } else {
        document.getElementById('endereco-rua').disabled = true;
        document.getElementById('endereco-numero').disabled = true;
        document.getElementById('endereco-complemento').disabled = true;
        document.getElementById('endereco-cep').disabled = true;
        document.getElementById('endereco-cidade').disabled = true;
        document.getElementById('endereco-uf').disabled = true;
        document.getElementById('btn-endereco').innerText = 'Editar';
        document.getElementById('botao-endereco-salvar').hidden = true;
    }
}