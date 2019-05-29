let botaoAdicionar = document.querySelector("#adicionar-item");
botaoAdicionar.addEventListener("click", function(event) {
    event.preventDefault();
    
    let listaItens = document.getElementsByClassName("item")
    
    limpaTabela(".tabela");
    
    for (let i=0; i < listaItens.length; i++){
        item ={
            nome: listaItens[i].querySelector(".form-nome").textContent,
            qtd: listaItens[i].querySelector(".input-qtd").value
        }
        adicionaItemNaTabela(item, ".tabela");
    }
});