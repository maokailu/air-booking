import React from 'react';
import './style.scss';
import Flipsnap from '../../resources/flipsnap.js';
export default class Tab extends React.Component {
  constructor(props) {
    super(props);
  }
  state = {
    current: 0
  };
  componentDidMount() {
    console.log('test');
    const distance = document.getElementById('flipsnap').offsetWidth / 3;
    this.flipsnap = Flipsnap('#flipsnap', {
      distance: distance,
      maxPoint: 2
    });
    this.flipsnap.element.addEventListener('fstouchmove', ev=> {
      if ((!this.flipsnap.hasNext() && ev.direction === 1) ||(!this.flipsnap.hasPrev() && ev.direction === -1)) {
        ev.preventDefault();
      }
    });
    this.flipsnap.element.addEventListener('fstouchend', ev=> {
      this.setState({ current: ev.newPoint });
    });
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
            React.Children.map(this.props.children,(element,index) => {
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
              React.Children.map(this.props.children, (element,index) => {
                return (
                  <div key={index}>{ element }</div>
                )
              })
            }
          </div>
        </div>
      </div>
    );
  }
}

// How to use the Tab, like this in your jsx file:
// 1.import App from <path>
// 2.
// <App>
//     <div name="one">
//         第一部分
//     </div>
//     <div name="two">
//         第二部分
//     </div>
//     <div name="three">
//         第三部分
//     </div>
// </App>
// master
// tab
// tab
// tab test
