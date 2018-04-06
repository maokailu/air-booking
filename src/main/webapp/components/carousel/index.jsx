import React from 'react';
import './style.scss';
import Flipsnap from '../../resources/flipsnap.js';
export default class Carousel extends React.Component {
  constructor(props) {
    super(props);
  }
  state = {
    current: 0
  };
  componentDidMount() {
    const distance = document.getElementById('flipsnap').offsetWidth / 3;
    this.flipsnap = Flipsnap('#flipsnap', {
      distance: distance,
      maxPoint: 2
    });
    this.flipsnap.element.addEventListener('fstouchmove', ev=> {
      if ((!this.flipsnap.hasNext() && ev.direction === 1) || (!this.flipsnap.hasPrev() && ev.direction === -1)) {
        ev.preventDefault();
      }
    });
    this.flipsnap.element.addEventListener('fstouchend', ev=> {
      this.setState({ current: ev.newPoint });
    });
    this.timerID = setInterval(
      () => {
        if (this.state.current !== 2) {
          this.toggle(this.state.current + 1);
        } else {
          this.toggle(0);
          // 使之朝右移
        }
      },
      2000
    );
  }
  componentWillUnmount() {
    clearInterval(this.timerID);
  }
  toggle = index => {
    this.setState({ current: index });
    this.flipsnap.moveToPoint(index);
  }
  render() {
    return (
      <div className="tab">
        <div className="nav">
          {
            React.Children.map(this.props.children, (element, index) => {
              return (
                <span key={index} onClick={()=> this.toggle(index)}
                  className={ this.state.current === index ? 'active' : '' }>{ element.props.name }</span>
              );
            })
          }
        </div>
        <div className="content">
          <div id="flipsnap">
            {
              React.Children.map(this.props.children, (element, index) => {
                return (
                  <div key={index}>{ element }</div>
                );
              })
            }
          </div>
        </div>
      </div>
    );
  }
}
// interval should stop when onmouseover and continue when onmouseout in windows,
// but onmouseover doesn't work on div even add tabindex='-1'
// 4 then 0
// add lazy load component
