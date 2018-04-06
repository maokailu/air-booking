import React from 'react';
// import './style.scss';
export default function Icon(props) {
  return (
    <div>
      {props.type === 'loading' && <div className = "loading">
        {
          (new Array(8)).fill(0).map((num, index) =>
            <i key = {index + 1} className = {'pip' + (index + 1)}></i>
          )
        }
      </div>}
      {props.type === 'success' && <i className = "success">
      </i>}
      {props.type === 'error' && <i className = "error">
      </i>}
      {props.type === 'warning' && <i className = "warning">
      </i>}
      {props.type === 'warning' && <i className={props.arrow_direction_type}></i>}
    </div>
  );
}
