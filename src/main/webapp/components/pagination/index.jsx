import React from 'react';
import Page from './page';
import '../adaptation';
export default class Pagination extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      current: 1,
      pageNums: [1, 2, 3, 4, 5, 0, 50]
    };
  }

  minPageNum = 1;
  maxPageNum = 50;
  toggle = (pageNum, maxPageNum, minPageNum) => {
    this.setState({
      current: pageNum
    });
    if (pageNum >= minPageNum && pageNum <= minPageNum + 2) {
      this.setState({
        pageNums: [minPageNum, minPageNum + 1, minPageNum + 2, minPageNum + 3, minPageNum + 4, 0, maxPageNum]
      });
    } else if (pageNum >= maxPageNum - 2 && pageNum <= maxPageNum) {
      this.setState({
        pageNums: [minPageNum, 0, maxPageNum - 4, maxPageNum - 3, maxPageNum - 2, maxPageNum - 1, maxPageNum]
      });
    } else if (pageNum === 4 || pageNum === maxPageNum - 1) {
      // debugger
      this.setState({
        pageNums: [minPageNum, pageNum - 2, pageNum - 1, pageNum, pageNum + 1, pageNum + 2, 0, maxPageNum]
      });
    } else if (pageNum >= 5 && pageNum <= maxPageNum - 2) {
      this.setState({
        pageNums: [minPageNum, 0, pageNum - 2, pageNum - 1, pageNum, pageNum + 1, pageNum + 2, 0, maxPageNum]
      });
    }
    console.log(minPageNum);
  }
  render() {
    const pageNums = this.state.pageNums;

    return (
      <div className = "pagination">
        {
          pageNums.map((pageNum, index) =>
            <Page
              key={index}
              pageNum={pageNum}
              maxPageNum={this.maxPageNum}
              minPageNum={this.minPageNum}
              current={this.state.current}
              toggle={this.toggle}
            />
          )
        }
      </div>
    );
  }
}
