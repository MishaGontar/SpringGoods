loadGoods()

function loadGoods() {
    const http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if (http.readyState === 4 && http.status === 200) {
            const goods = JSON.parse(http.responseText)
            let html = "<tr>" +
                "<th>Goods id</th>" +
                "<th>Goods name</th>" +
                "<th>Goods cost</th>" +
                "</tr>"
            goods.forEach(good => {
                html += `<tr> 
                         <td>${good.id}</td>
                         <td>${good.name}</td>
                         <td>${good.cost}</td>
                         <td><button onclick="deleteGoods(${good.id})">Delete</button></td>
                         </tr>`
            })
            document.getElementById("GoodsList").innerHTML = html;
        }
    }
    http.open("GET", "http://localhost:8080/goods/findAll", true)
    http.send()
}

function searchGoodsByName() {
    const name = document.getElementById("search_name").value
    const http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if (http.status === 200 && http.readyState === 4) {
            const goods = JSON.parse(http.responseText)
            document.getElementById("result").innerHTML = `
                    ID: ${goods.id} <br> 
                    NAME: ${goods.name} <br>
                    Cost: ${goods.cost} <br>`
        }
    }
    http.open("GET", `http://localhost:8080/goods/findByName?name=${name}`, true)
    http.send()
}

function deleteGoods(id) {
    const http = new XMLHttpRequest();
    http.open("GET", `http://localhost:8080/goods/delete/${id}`, true)
    http.send()
    http.onreadystatechange = () => {if (http.status === 200 && http.readyState === 4)loadGoods()}
}

function creteGoods() {
    const name = document.getElementById("name").value;
    const cost = document.getElementById("cost").value;
    const http = new XMLHttpRequest()
    http.open("POST", `http://localhost:8080/goods/saveGo`)
    http.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    http.send(JSON.stringify({name: name, cost: cost}))
    http.onreadystatechange = () => {
        if (http.status === 200 && http.readyState === 4) loadGoods()
        window.location.reload()
    }
}

