urlServicioProducts = "http://localhost:8081/api/products";
urlServicioCategories = "http://localhost:8081/api/categories";
urlServicioUnity = "http://localhost:8081/api/unity";
let agregarProductosNuevos = document.getElementById("agregarProductosNuevos");
let nuevaCategoria = document.getElementById("categoryId");
let nuevaUnidad = document.getElementById("unityId");

const otroProducto = async () => {
  try {
    const response = await fetch(urlServicioProducts);
    if (!response.ok) {
      throw new Error(`Data response no esta ok ${response.statusText}`);
    }
    const data = await response.json();

    let items = [];

    data.forEach((product) => {
      items.push(`
        <tr>
          <th class="text-xl">${product.name}</th>
          <th class="text-xl">${product.price}</th> 
          <th class="text-xl">${product.stock}</th>
          <th class="text-xl">${product.categoryId.name}</th>
          <th class="text-xl">${product.unityId.name}</th>
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
