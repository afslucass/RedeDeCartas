

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
                                      headers: {'Content-type': 'application/x-www-form-urlencoded'},
                                      body: 'mensagem=mostrar', })
    let json = await req.json()
    console.log(JSON.stringify(json))
}

ajax()


// Trata o Response:

