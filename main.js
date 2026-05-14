import { createRoot } from "react-dom/client";
import Main from "./components/Main";
import Footer from "./components/Footer";
import Body from "./components/Body";
import About from "./components/About";
import Contact from "./components/Contact";
import React from "react";
import Header from "./components/Header";
import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import Error from "./components/Error";
import ResDetails from "./components/ResDetails";

var htmlRoot = document.getElementById("root");

const AppRoot = () => (
  <div className="app-root">
    <Header />
    <Outlet />
    <Footer />
  </div>
);
const appRouter = createBrowserRouter([
  {
    path: "/",
    element: <AppRoot />,
    errorElement: <Error />,
    children: [
      {
        index: true,
        element: <Body />,
      },
      {
        path: "/home",
        element: <Body />,
      },
      {
        path: "/resDetails/:resId",
        element: <ResDetails />,
      },
      {
        path: "/about",
        element: <About />,
      },
      {
        path: "/contact",
        element: <Contact />,
      },
    ],
  },
]);

createRoot(htmlRoot).render(
  <React.StrictMode>
    <RouterProvider router={appRouter} />
  </React.StrictMode>,
);
