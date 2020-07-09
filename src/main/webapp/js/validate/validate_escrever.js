function validar() {
    if(form.text.length <=1 || form.text.length > 1000){
        alert("Texto não Valido")
        return false
    }
}