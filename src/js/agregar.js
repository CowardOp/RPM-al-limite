urlServicio = "http://localhost:8081/api/products";
let agregarProductosNuevos = document.getElementById("agregarProductosNuevos");
// const agregarProductos = () => {
//   console.log("Agregando productos");
//   var data = [];
//   var success = function (response) {
//     console.log(response);
//     agregarProductosNuevos.innerHTML = response;
//   };

//   $.ajax({
//     type: "GET",
//     headers: {
//       Accept: "application/json",
//       "Content-type": "application/jason",
//     },
//     url: urlServicio,
//     context: data,
//     dataType: "json",
//     success: success,
//   });
// };

// agregarProductos();

const otroProducto = async () => {
  try {
    const response = await fetch(urlServicio);
    if (!response.ok) {
      throw new error(`Data response was not ok ${response.statusText}`);
    }
    const data = await response.json();
    console.log(data);
    agregarProductosNuevos.innerHTML = `<th>${data[0].name}</th>
    <th>${data[0].price}</th> 
    <th>${data[0].stock}</th>
    <th>${data[0].categoryId.name}</th>
    <th>${data[0].unityId.name}</th>
    <th><button class="btn btn-xs btn-accent">Editar</button></th>
    <th><button class="btn btn-xs btn-error">Eliminar</button></th>
    `;
  } catch (e) {
    console.log(`Error ${e}`);
  }
};

otroProducto();
