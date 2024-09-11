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
          <th class="text-xl">${producto.name}</th>
          <th class="text-xl">${producto.price}</th> 
          <th class="text-xl">${producto.stock}</th>
          <th class="text-xl">${producto.categoryId.name}</th>
          <th class="text-xl">${producto.unityId.name}</th>
          <th class="flex justify-center"><button class="btn btn-xs btn-accent">Editar</button><button class="btn btn-xs btn-error">Eliminar</button></th>
        </tr>
      `);
    });

    agregarProductosNuevos.innerHTML = items.join("");
  } catch (e) {
    console.log(`Error ${e}`);
  }
};

otroProducto();
