
function validar() {
    let nome = form_cadastro.nome.value
    let sobrenome = form_cadastro.sobrenome.value
    let nick = form_cadastro.nick.value
    let data = form_cadastro.data.value
    let email = form_cadastro.email.value
    let senha = form_cadastro.senha.value
    let confirmasenha = form_cadastro.confirmasenha.value

    if(nome.length <= 1 || nome.length > 20){
        alert("Nome Inválido")
        return false
    }
    if(sobrenome.length <= 1 || sobrenome.length > 40){
        alert("Sobrenome Inválido")
        return false
    }
    if(nick.length <= 1 || nick.length > 40){
        alert("Nick Inválido")
        return false
    }
    if(email.length <= 1 || email.length > 40 || email.search("@") == -1){
        alert("Email Inválido")
        return false
    }
    if(senha.length <= 1 || senha.length > 40){
        alert("Senha Inválido")
        return false
    }
    if(senha != confirmasenha){
        alert("As senha não coincidem")
        return false
    }
    return true
}

