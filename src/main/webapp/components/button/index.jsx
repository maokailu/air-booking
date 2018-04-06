import React from 'react';
import './style.scss';

const Button = (props) => {
  const clickHandler = () => {
    console.log('click the button to do somethings');
  };
  return (
    <div className="button" onClick = {clickHandler}>{props.text || 'there is the button content'}</div>
  );
};
export default Button;
