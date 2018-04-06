import React from 'react';
import './style.scss';
import classNames from 'classnames';
export default class Day extends React.Component {
  constructor(props) {
    super(props);
  }
  clickHandler = (index) => {
    this.props.clickHandler(index);
  }
  render() {
    const day = this.props.day;
    let index = this.props.index;
    let sizeOfPrevShowDays = this.props.sizeOfPrevShowDays;
    let sizeOfCurrentMonth = this.props.sizeOfCurrentMonth;
    let tdStyle = classNames({
      'fadeOut': index < sizeOfPrevShowDays || index >= sizeOfPrevShowDays + sizeOfCurrentMonth,
      'currentIndex': index ===  this.props.currentIndex
    });
    return (
      <td
        onClick = {() => this.clickHandler(index, event)}
        className={tdStyle}
      >
        {(day >= 1 && day <= 9) ? '0' + day : day}
      </td>
    );
  }
}
