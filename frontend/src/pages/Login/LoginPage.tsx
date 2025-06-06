import TextField from "../../components/textField";
import './LoginPage.css';
import { useState } from "react";

function LogInPage() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [isPasswordValid, setIsPasswordValid] = useState(true);

    const validateEmail = (email: string) => {
        //const emailRegex = /[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
        const emailRegex = /^[a-zA-Z0-9._%+-]+@loyalbridge\\.io$/;
        return emailRegex.test(email);
    };

    const validatePassword = (password: string) => {
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{7,}$/;
        return passwordRegex.test(password);
    };

    const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        setEmail(value);
        setIsEmailValid(validateEmail(value));
    };

    const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const value = e.target.value;
        setPassword(value);
        setIsPasswordValid(validatePassword(value));
    };


return(
    <div className="login-outer">
        <div className="login-inner">
            <div className="left"></div>
            <div className="right">
                <p>LOGIN</p>
                <TextField 
                    type="email" 
                    value={email}
                    onChange={handleEmailChange}
                    placeholder="Enter Your Email"
                    isError={!isEmailValid}
                    errorMessage={!isEmailValid ? "Email must be a @loyalbridge.io address" : ""}
                />
                <TextField 
                    type="password" 
                    value={password}
                    onChange={handlePasswordChange}
                    placeholder="Enter Your Password"
                    isError={!isPasswordValid}
                    errorMessage={!isPasswordValid ? "invalid password" : ""}
                />
            </div>
        </div>
    </div>
);
}

export default LogInPage;