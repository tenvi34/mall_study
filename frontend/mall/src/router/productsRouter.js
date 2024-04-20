import { Suspense, lazy } from "react";
import { Navigate } from "react-router-dom";

const productsRouter = () => {

    const Loading = <div>Loading....</div>

    const ProductsList = lazy(() => import("../pages/products/ListPage"))
    const ProductsAdd = lazy(() => import("../pages/products/AddPage"))
    const ProductsRead = lazy(() => import("../pages/products/ReadPage"))
    const ProductsModify = lazy(() => import("../pages/products/ModifyPage"))

    return [
        {
            path: "list",
            element: <Suspense fallback={Loading}><ProductsList/></Suspense>
        },
        {
            path: "",
            element: <Navigate replace to="/products/list"/>
        },
        {
            path: "add",
            element: <Suspense fallback={Loading}><ProductsAdd/></Suspense>
        },
        {
            path: "read/:pno",
            element: <Suspense fallback={Loading}><ProductsRead/></Suspense>
        },
        {
            path: "modify/:pno",
            element: <Suspense fallback={Loading}><ProductsModify/></Suspense>
        }
    ]
}

export default productsRouter;