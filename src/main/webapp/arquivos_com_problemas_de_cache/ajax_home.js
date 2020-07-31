

// Recebe o responce do servidor(JSON com nick, id, menssagens e String das fotos em base 64):

// (function ajax() {
//     let xhttp = new XMLHttpRequest()

//     xhttp.onreadystatechange = function() {
//         if (this.readyState == 4 && this.status == 200) {
//             var req = JSON.parse(this.responseText)
            
//         }
//     }

//     xhttp.open("POST", "action", true)
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send("mensagem=mostrar")
// })()

async function ajax(){
    let req = await fetch("action", { method: 'POST',
                                      headers: {'Content-type': 'application/xx-www-form-urlencoded'},
                                      body: 'mensagem=mostrar', })
    let json = await req.json()
    TrataDadosDaAjax(json)
}

ajax()

function TrataDadosDaAjax(json) {
    let section = document.querySelector("#posts")
    
    json.attributes.forEach(element => {
        
        let novoPost = document.createElement("article")
        
        let foto = "";
        for(let i = 0; i < json.images.length; i++){
            if(element.nick == json.images[i].nick){
                foto = json.images[i].image
                break
            }
        }
        novoPost.innerHTML = 
            `<div id=foto><img src='data:image/jpeg;charset=utf-8;base64,${foto}' alt='foto'></div><div id='nick'>${element.nick}</div><div id='descricao'>${element.message}...</div><form method="POST" action="action"><input type="hidden" name="mensagem" value="visualizar"><input type="hidden" name="id" value="${element.id}"><input type="submit" value="Visualizar"></form>`

        section.appendChild(novoPost)    
        });
}