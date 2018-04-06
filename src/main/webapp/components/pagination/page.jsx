import React from 'react';
import './style.scss';
import classNames from 'classnames';
export default class Page extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }
  toggle = (pageNum, maxPageNum, minPageNum) => {
    if (pageNum !== 0) {
      this.props.toggle(pageNum, maxPageNum, minPageNum);
    }
  }
  render() {
    const pageNum = this.props.pageNum;
    let current = this.props.current;
    var pageItem = classNames({
      'pageItem': pageNum !== 0,
      'current': current === pageNum,
      'points': pageNum === 0
    });
    return (
      <div
        className = {pageItem}
        onClick={this.toggle.bind(this, pageNum, this.props.maxPageNum, this.props.minPageNum)}
      >
        {pageNum === 0 ? '...' : pageNum}
      </div>
    );
  }
}
