import React from 'react';
import './style.scss';

export default class Toggle extends React.Component {
  constructor(props) {
    super(props);
  }
  state = {
    toggle: false
  };
  componentDidMount() {
  }
  toggle = () => {
    this.setState(prevState =>({
      toggle: !prevState.toggle
    }));
  }
  render() {
    return (
      <div className="box">
        <span className={this.state.toggle ? 'icon-toggle-on' : 'icon-toggle-off'} onClick={this.toggle}></span>
      </div>
    );
  }
}
