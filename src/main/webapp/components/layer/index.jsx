import React from 'react';
import ReactDOM from 'react-dom';
import './style.scss';

const appRoot = document.getElementById('app-root');
const modalRoot = document.getElementById('modal-root'); // 容纳整个弹出层，与app层平行

class Modal extends React.Component {
  constructor(props) {
    super(props);
    this.el = document.createElement('div');
  }

  componentDidMount() {
    modalRoot.appendChild(this.el);
  }

  componentWillUnmount() {
    modalRoot.removeChild(this.el);
  }

  render() {
    return ReactDOM.createPortal(
      this.props.children,
      this.el,
    );
  }
}
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { showModal: false };
    this.handleShow = this.handleShow.bind(this);
    this.handleHide = this.handleHide.bind(this);
  }

  handleShow() {
    this.setState({ showModal: true });
  }

  handleHide() {
    this.setState({ showModal: false });
  }

  render() {
    const modal = this.state.showModal ? (
      // Layer,将渲染到父元素app-root外与app-root平行的元素modal-root中，但在app中通过showModel控制Moal是否渲染。
      <Modal>
        <div className="modal">
          <button onClick={this.handleHide}>Hide modal</button>
        </div>
      </Modal>
    ) : null;

    return (
      <div className="app">
        This div has overflow: hidden.
        <span onClick={this.handleShow}>Show modal</span>
        {modal}
      </div>
    );
  }
}

export { App, appRoot };
