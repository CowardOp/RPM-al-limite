document.addEventListener("DOMContentLoaded", () => {
  const buttonMenu = getById("productButton");
  const productMenu = getById("productMenu");
  const menuIcon = getById("menuIcon");
  const header = getById("nav");

  // Log-in form handling
  logIn.addEventListener("click", () => formLogIn.classList.add("show"));
  temporal.addEventListener("click", () => formLogIn.classList.remove("show"));

  // Log-out form handling
  logOut.addEventListener("click", () => formLogOut.classList.add("show"));
  temporalOut.addEventListener("click", () =>
    formLogOut.classList.remove("show")
  );

  let lastScrollTop = 0;

  // Verifica si los elementos existen antes de agregar eventos
  if (buttonMenu && productMenu && menuIcon) {
    buttonMenu.addEventListener("click", () => {
      productMenu.classList.toggle("visible");
      menuIcon.classList.toggle("visible");
    });
  } else {
    console.warn("Some elements are missing");
  }

  // Oculta o muestra el navbar basado en el scroll
  window.addEventListener("scroll", () => {
    const currentScroll = window.scrollY || document.documentElement.scrollTop;
    header.style.top = currentScroll > lastScrollTop ? "-65px" : "0";
    lastScrollTop = Math.max(currentScroll, 0);
  });

  // Desplazamiento suave para anclas
  document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", (e) => {
      e.preventDefault();
      const targetId = anchor.getAttribute("href");
      if (targetId && targetId !== "#") {
        const targetElement = document.querySelector(targetId);
        targetElement?.scrollIntoView({
          behavior: "smooth",
          block: "start",
        });
      }
    });
  });

  // Manejo de botones de incremento/decremento
  document
    .querySelectorAll(".add")
    .forEach((button) =>
      button.addEventListener("click", () =>
        modifyCount(button, 1, "blink-green")
      )
    );

  document
    .querySelectorAll(".rest")
    .forEach((button) =>
      button.addEventListener("click", () =>
        modifyCount(button, -1, "blink-red")
      )
    );
});

// Función auxiliar para obtener un elemento por ID
function getById(id) {
  return document.getElementById(id);
}

// Función para modificar el contador
function modifyCount(button, change, blinkClass) {
  const countSpan = button.parentElement.querySelector(".count");
  let count = parseInt(countSpan.textContent, 10);

  if (change > 0 || count > 0) {
    countSpan.textContent = count + change;

    // Añadir animación de parpadeo
    countSpan.classList.add(blinkClass);
    setTimeout(() => countSpan.classList.remove(blinkClass), 500);
  }
}
