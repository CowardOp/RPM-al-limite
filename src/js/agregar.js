urlServicio = "http://localhost:8081/api/products";
let agregarProductosNuevos = document.getElementById("agregarProductosNuevos");

const otroProducto = async () => {
  try {
    const response = await fetch(urlServicio);
    if (!response.ok) {
      throw new Error(`Data response was not ok ${response.statusText}`);
    }
    const data = await response.json();

    let items = [];

    data.forEach((producto) => {
      items.push(`
        <tr>
          <th>${producto.name}</th>
          <th>${producto.price}</th> 
          <th>${producto.stock}</th>
          <th>${producto.categoryId.name}</th>
          <th>${producto.unityId.name}</th>
          <th><button class="btn btn-xs btn-accent">Editar</button></th>
          <th><button class="btn btn-xs btn-error">Eliminar</button></th>
        </tr>
      `);
    });

    agregarProductosNuevos.innerHTML = items.join("");
  } catch (e) {
    console.log(`Error ${e}`);
  }
};

otroProducto();
