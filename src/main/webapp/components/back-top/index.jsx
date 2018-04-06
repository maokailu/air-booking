import React from 'react';
import './style.scss';

export default class BackTop extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      showBackTop: false
    };
  }
  componentDidMount() {
    window.addEventListener('scroll', this.showBackTop);
  }
  showBackTop = () => {
    // webkit: document.body.scrollTop; others: document.documentElement.scrollTop
    var osTop = document.documentElement.scrollTop || document.body.scrollTop;
    if (osTop > 0) {
      this.setState({
        showBackTop: true
      });
    } else {
      this.setState({
        showBackTop: false
      });
    }
  }
  backTop = () => {
    window.scrollTo(0, 0);
  }
  render() {
    return (
      <div>
        <div style={{ padding: '130px', background: 'gray' }}>top</div>
        <div className="back_top"
          style={{ display: this.state.showBackTop ? 'block' : 'none' }}
          onClick = {this.backTop}>
          回到顶部
        </div>
        <div style={{ position: 'absolute', top: '1600px', padding: '130px', background: 'gray' }}>bottom</div>
      </div>
    );
  }
}