import React from 'react';
import './style.scss';
import classNames from 'classnames';
export default class SelectOption extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <option
        value = {this.props.value}
      >
        {this.props.text}
      </option>
    );
  }
}
