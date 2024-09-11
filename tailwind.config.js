/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./*.html", "./public/*.html"],
  // daisyui: {
  //   themes: [
  //     {
  //       mytheme: {
  //         "base-100": "#f2f2f2",

  //         info: "#00a1fe",
  //       },
  //     },
  //   ],
  // },
  plugins: [require("daisyui")],
};
