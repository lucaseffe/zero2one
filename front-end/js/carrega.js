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

function montaTd(dado, id_tabela) {
    let td = document.createElement("td");
    td.classList.add(id_tabela);
    td.textContent = dado;

    return td;
}

function montaTdInput(id_tabela) {
    let td = document.createElement("td");
    let input = document.createElement("input");
    input.setAttribute("type","number");
    input.classList.add("w3-input");
    input.classList.add("w3-border");
    input.classList.add("input-qtd");
    td.classList.add(id_tabela);
    td.appendChild(input)
    return td;
}

function montaTr(item, id_tabela) {
    let itemTr = document.createElement("tr");
    itemTr.classList.add("item");
    if (id_tabela == "#tabela") {
        itemTr.appendChild(montaTd(item.nome, "info-nome"));
        itemTr.appendChild(montaTd(item.qtd, "info-qtd"));
    } else {
        itemTr.appendChild(montaTd(item.item, "form-nome"));
        itemTr.appendChild(montaTdInput("form-qtd"));
    };
    
    return itemTr;
}

function adicionaItemNaTabela(item, id_tabela) {
    var itemTr = montaTr(item, id_tabela);
    var tabela = document.querySelector(id_tabela);
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
            adicionaItemNaTabela(itemObj, "#tabela-form");
        });
    });
};

function limpaTabela(id_tabela){
    document.querySelector(id_tabela).innerHTML = null;
}

buscaDados();