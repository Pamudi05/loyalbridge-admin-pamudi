import Button from "../../components/button";
import TextField from "../../components/textField";
import './LoginPage.css';
import { useState } from "react";

export function LogInPage() {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [isPasswordValid, setIsPasswordValid] = useState(true);

    const validateEmail = (email: string) => {
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

    const handleClick = () => {
        
    }

    return(
        <div className="login-outer">
            <div className="login-inner">
                <div className="left"></div>
                <div className="right">
                    <p>LOGIN</p>
                    <form style={{display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
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
                            errorMessage={!isPasswordValid ? "Wrong password. Please check and retry." : ""}
                        />
                        <Button
                            // loading={authState.loading}
                            onClick={handleClick}
                            marginTop="40px"
                            fontWeight={700}
                            borderRadius="40px"
                        > Login </Button>
                    </form>
                </div>
                
            </div>
        </div>
    );
}

export default LogInPage;