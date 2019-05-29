const link = 'https://api.conexaonfe.com.br/v1/itens'

function busca(){
    return fetch(link,{
        method: 'GET',
        headers: {
            'Authorization': 'eee',
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        return response.json();
    })
    .then(res => {
        return res;
    })
    .catch(error => {
        console.log(error);
    })
}

function montaTd(dado, classe) {
    let td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}

function montaTdInput(classe) {
    let td = document.createElement("td");
    let input = document.createElement("input");
    input.setAttribute("type","number");
    input.classList.add("input-qtd");
    td.classList.add(classe);
    td.appendChild(input)
    return td;
}

function montaTr(item, classe) {
    let itemTr = document.createElement("tr");
    itemTr.classList.add("item");
    if (classe == ".tabela") {
        itemTr.appendChild(montaTd(item.nome, "info-nome"));
        itemTr.appendChild(montaTd(item.qtd, "info-qtd"));
    } else {
        itemTr.appendChild(montaTd(item.item, "form-nome"));
        itemTr.appendChild(montaTdInput("form-qtd"));
    };
    
    return itemTr;
}

function adicionaItemNaTabela(item, classe) {
    var itemTr = montaTr(item, classe);
    var tabela = document.querySelector(classe);
    tabela.appendChild(itemTr);
}

function buscaDados (){
    busca().then(resposta => {
        let listaItem = resposta;
        listaItem.forEach(item => {
            let itemObj = {
                id: item.id,
                item: item.item
            };
            adicionaItemNaTabela(itemObj, ".tabela-form");
        });
    });
};

function limpaTabela(classe){
    document.querySelector(classe).innerHTML = null;
}

buscaDados();