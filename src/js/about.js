const buttonMenu = document.getElementById("productButton");
const productMenu = document.getElementById("productMenu");
const menuIcon = document.getElementById("menuIcon");
const btn = document.getElementById("btn");
const header = document.querySelector("nav");

// Log-in form handling
logIn.addEventListener("click", () => formLogIn.classList.add("show"));
temporal.addEventListener("click", () => formLogIn.classList.remove("show"));

// Log-out form handling
logOut.addEventListener("click", () => formLogOut.classList.add("show"));
temporalOut.addEventListener("click", () =>
  formLogOut.classList.remove("show")
);

document.addEventListener("DOMContentLoaded", () => {
  buttonMenu.addEventListener("click", () => {
    productMenu.classList.toggle("visible");
    menuIcon.classList.toggle("visible");
  });
  let lastScrollTop = 0;
  // oculta navbar al hacer el scroll

  window.addEventListener("scroll", function () {
    let currentScroll = window.scrollY || document.documentElement.scrollTop;

    if (currentScroll > lastScrollTop) {
      header.style.top = "-65px";
    } else {
      header.style.top = "0";
    }

    lastScrollTop = currentScroll <= 0 ? 0 : currentScroll; // Para Firefox
  });

  //centra los contenedores a las pantalla "#"
  document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      e.preventDefault();

      const targetId = this.getAttribute("href");

      // Comprueba si targetId es un valor válido
      if (targetId && targetId !== "#") {
        const targetElement = document.querySelector(targetId);

        if (targetElement) {
          targetElement.scrollIntoView({
            behavior: "smooth",
            block: "start",
          });
        }
      }
    });
  });
});
