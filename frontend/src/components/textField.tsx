import { useState } from "react";

export interface TextFieldProps {
    onChange?: (event: React.ChangeEvent<HTMLInputElement>) => void;
    value?: string;
    type?: string;
    placeholder?: string;
    className?: string;
    color?: string;
    width?: string;
    height?: string;
    textColor?: string;
    borderColor?: string;
    borderRadius?: string;
    marginTop?: string;
    marginLeft?: string;
    fontSize?: string;
    fontWeight?: number;
    fontFamily?: string;
    errorMessage?: string;
    isError?: boolean;
    style?: React.CSSProperties;
    inputRef?: React.RefObject<HTMLInputElement>;
}

const TextField: React.FC<TextFieldProps> = ({
    onChange,
    value,
    type = 'text',
    placeholder,
    className,
    color = "Black",
    width = '400px',
    height = '36px',
    textColor,
    borderColor,
    borderRadius = '41px',
    marginLeft = '20px',
    marginTop = '20px',
    fontSize = '14px',
    fontFamily = 'League Spartan',
    fontWeight = 500,
    errorMessage,
    isError = false,
    style,
    inputRef,
}) => {
    const [isHovered, setIsHovered] = useState(false);

    const inputStyle: React.CSSProperties = {
        backgroundColor: 'transparent',
        color: color,
        border: 'none',
        fontSize: fontSize,
        fontWeight: fontWeight,
        fontFamily: fontFamily,
        outline: 'none',
        padding: '4px 12px 4px 12px',
        width: '100%',
        ...style,
    };
    
    return(
        <div>
            <div 
            style={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'left',
                width: width,
                height: height,
                backgroundColor: "white",
                color: "black",
                padding: '8px 12px 8px 12px',
                marginTop: marginTop,
                border: `2px solid ${isHovered ? '#000000' : '#FFFFFF'}`,
                borderRadius: borderRadius,
            }}
                onMouseEnter={() => setIsHovered(true)}
                onMouseLeave={() => setIsHovered(false)}
            >
                <input
                    ref={inputRef}
                    type={type}
                    value={value}
                    onChange={onChange}
                    placeholder={placeholder}
                    style={inputStyle}
                />
            </div>
            {isError && <span style={{ fontFamily: fontFamily, color: '#FF0000CC', fontSize: '15px', marginLeft: marginLeft}}>{errorMessage}</span>}
        </div>
    );
}

export default TextField;