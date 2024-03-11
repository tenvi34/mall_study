import { Link } from "react-router-dom";

const BasicMenu = () => {
    return (
        <nav id='navbar' className="flex bg-blue-300">

            <div className="w-4/5 bg-gray-500">
                <ul className="flex p-4 text-white font-bold"> 
                {/* 메인페이지 */}
                <li className="pr-6 text-2xl">
                    <Link to={'/'}>Main</Link>
                </li>
                {/* About 페이지 */}
                <li className="pr-6 text-2xl">
                    <Link to={'/about'}>About</Link>
                </li>
                {/* Todo 페이지 */}
                <li className="pr-6 text-2xl">
                    <Link to={'/todo'}>Todo</Link>
                </li>
                </ul>
            </div>

            <div className="w-1/5 flex justify-end bg-orange-300 p-4 font-medium">
                <div className="text-white text-sm m-1 rounded">
                    Login
                    {/* <Link to={'/login'}>Login</Link> */}
                </div>
            </div>
        </nav>
    );
}

export default BasicMenu;