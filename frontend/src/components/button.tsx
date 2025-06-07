import { ReactNode, useState } from "react";

export interface ButtonProps {
    onClick?: () => void;
    icon?: ReactNode;
    children?: ReactNode;
    className?: string;
    color?: string;
    width?: string;
    height?: string;
    textColor?: string;
    borderColor?: string;
    borderRadius?: string;
    lineHeight?: string;
    fontWeight?: number;
    fontSize?: string;
    justifyContent?: string;
    marginTop?: string;
    marginLeft?: string;
    disabled?: boolean;
    loading?: boolean;
    style?: React.CSSProperties;
}

const Button: React.FC<ButtonProps> = ({
    onClick,
    children,
    className,
    fontSize = '16px',
    width = '400px',
    height = '36px',
    borderRadius = '8px',
    fontWeight = 400,
    lineHeight = '20px',
    marginTop = '10px',
    justifyContent = 'center',
    style,
    disabled = false,
    loading = false,
}) => {
    const [isHovered, setIsHovered] = useState(false);

    const handleMouseEnter = () => {
    setIsHovered(true);
    };

    const handleMouseLeave = () => {
        setIsHovered(false);
    };
    return(
        <div
        onClick={onClick}
        className={`btn ${className}`}
        style={{
            position: 'relative',
            borderRadius: borderRadius,
            backgroundColor: disabled ? "gray" : isHovered ? "white": "black" ,
            width: width,
            height: height,
            fontFamily: 'League Spartan',
            fontSize: fontSize,
            fontWeight: fontWeight,
            color: disabled ? "gray" : isHovered ? "black"  :  "white",
            display: 'flex',
            transition: 'background-color 0.3s ease, border 0.3s ease, color 0.3s ease',
            justifyContent: justifyContent,
            alignItems: 'center',
            overflow: 'hidden',
            padding: '4px 8px 4px 8px',
            cursor: loading ? 'default' : disabled ? 'not-allowed' : 'pointer',
            border: disabled ? `0` : isHovered ? `2px solid "black"` : `2px solid black`,
            lineHeight: lineHeight,
            marginTop: marginTop,
            ...style,
        }}
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
        >
      {!loading && (
        <div style={{ display: 'flex', alignItems: 'center' }}>
          <span>{children}</span>
        </div>
      )}
      {loading && <span className="spinner" />}
    </div>
    );
}

export default Button;