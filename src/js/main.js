document.addEventListener("DOMContentLoaded", () => {
  const buttonMenu = document.getElementById("productButton");
  const productMenu = document.getElementById("productMenu");
  const menuIcon = document.getElementById("menuIcon");
  const header = document.querySelector("nav");
  const logIn = document.getElementById("logIn");
  const logOut = document.getElementById("logOut");
  const temporal = document.getElementById("temporal");
  const temporalOut = document.getElementById("temporalOut");
  const formLogIn = document.getElementById("formLogIn");
  const formLogOut = document.getElementById("formLogOut");

  let lastScrollTop = 0;
  let currentIndex = 0;

  // Toggle menu visibility
  buttonMenu.addEventListener("click", () => {
    productMenu.classList.toggle("visible");
    menuIcon.classList.toggle("visible");
  });

  // Log-in form handling
  logIn.addEventListener("click", () => formLogIn.classList.add("show"));
  temporal.addEventListener("click", () => formLogIn.classList.remove("show"));

  // Log-out form handling
  logOut.addEventListener("click", () => formLogOut.classList.add("show"));
  temporalOut.addEventListener("click", () =>
    formLogOut.classList.remove("show")
  );

  // Hide navbar on scroll
  window.addEventListener("scroll", () => {
    const currentScroll = window.scrollY || document.documentElement.scrollTop;
    header.style.top = currentScroll > lastScrollTop ? "-65px" : "0";
    lastScrollTop = Math.max(currentScroll, 0); // Prevent negative scroll values
  });

  // Smooth scroll for internal links
  document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      e.preventDefault();
      const targetId = this.getAttribute("href");
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

  // Discount carousel navigation
  const prevButton = document.querySelector(".prev");
  const nextButton = document.querySelector(".next");
  const discountImages = document.querySelector(".discount-images");
  const discountItems = document.querySelectorAll(".discount-item");

  const updateDiscount = () => {
    discountImages.style.transform = `translateX(${-currentIndex * 100}%)`;
  };

  nextButton.addEventListener("click", () => {
    currentIndex = (currentIndex + 1) % discountItems.length;
    updateDiscount();
  });

  prevButton.addEventListener("click", () => {
    currentIndex =
      (currentIndex - 1 + discountItems.length) % discountItems.length;
    updateDiscount();
  });

  updateDiscount();

  // Products accordion
  document.querySelectorAll(".products-header").forEach((header) => {
    header.addEventListener("click", () => {
      const content = header.nextElementSibling;
      document.querySelectorAll(".products-content").forEach((item) => {
        if (item !== content) item.style.maxHeight = null;
      });
      content.style.maxHeight = content.style.maxHeight
        ? null
        : `${content.scrollHeight}px`;
    });
  });
});
