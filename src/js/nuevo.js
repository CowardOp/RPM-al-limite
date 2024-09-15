urlServicioCategories = "http://localhost:8081/api/category";
urlServicioUnity = "http://localhost:8081/api/unity";
urlServicioProducts = "http://localhost:8081/api/products";

let nuevaCategoria = document.getElementById("categoryId");
let nuevaUnidad = document.getElementById("unityId");

const newCategories = async () => {
  try {
    const response = await fetch(urlServicioCategories);
    if (!response.ok) {
      throw new Error(`Data response no esta ok ${response.statusText}`);
    }
    const data = await response.json();
    console.log(data);

    let itemCategory = [];

    data.forEach((category) => {
      itemCategory.push(`<option class="text-white">${category.name}</option>`);
    });
    nuevaCategoria.innerHTML =
      `<option class="text-white" disabled selected> Seleccione una unidad</option>` +
      itemCategory.join("");
  } catch (e) {
    console.log(`Error ${e}`);
  }
};

newCategories();

const newUnity = async () => {
  try {
    const response = await fetch(urlServicioUnity);
    if (!response.ok) {
      throw new Error(`Data response no esta ok ${response.statusText}`);
    }
    const data = await response.json();
    console.log(data);

    let itemUnity = [];

    data.forEach((unity) => {
      itemUnity.push(`<option class="text-white">${unity.name}</option>`);
    });
    nuevaUnidad.innerHTML =
      `<option class="text-white" disabled selected> Seleccione una unidad</option>` +
      itemUnity.join("");
  } catch (e) {
    console.log(`Error ${e}`);
  }
};

newUnity();

const nuevoProducto = () => {
  console.log("nuevo producto");

  var data = convertirFormDataAJSON($("#formNuevo"));

  var resultado = (response) => {
    alert("El producto fue agregado");
    window.location.href = "agregar.html";
  };

  $.ajax({
    type: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    url: urlServicioProducts,
    data: data,
    dataType: "json",
    success: resultado,
  });
};

const convertirFormDataAJSON = (formData) => {
  let loginForm = formData.serializeArray();
  let loginObject = {};

  $.each(loginForm, function (i, v) {
    loginObject[v.name] = v.value;
  });
  return JSON.stringify(loginObject);
};
