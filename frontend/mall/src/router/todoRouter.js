import { Suspense, lazy } from "react";
import { Navigate } from "react-router-dom";

const Loading = <div>Loading....</div>
const TodoList = lazy(() => import("../pages/todo/ListPage"));
const ReadPage = lazy(() => import("../pages/todo/ReadPage"));

const todoRouter = () => {
    return [
        {
            path: "list",
            element: <Suspense fallback={Loading}><TodoList/></Suspense>,
        },
        {
            path: "",
            element: <Navigate replace to="/todo/list"/>
        },
        {
            path: "read/:tno",
            element: <Suspense fallback={Loading}><ReadPage/></Suspense>
        }
    ]
}

export default todoRouter;