import React from 'react';
import './style.scss';
export default class ProgressBar extends React.Component {
  constructor() {
    super();
    this.state = {
      showArea: true
    };
  }
  componentDidMount() {
    // this.previewFiles([]);
  }
  readFileSize = file => {
    let size = file.size / 1024;
    const aMultiples = ['KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    let fileSizeString = '';
    for (let i = 0; size > 1; size /= 1024, i++) {
      fileSizeString = size.toFixed(2) + ' ' + aMultiples[i];
    }
    return fileSizeString;
  }
  dragEnter = e => {
    e.stopPropagation();
    e.preventDefault();
  }
  dragOver = e => {
    e.stopPropagation();
    e.preventDefault();
  }
  drop = e => {
    e.stopPropagation();
    e.preventDefault();

    const dt = e.dataTransfer;
    const files = dt.files;
    this.previewFiles(files);
  }
  previewFiles = files => {
    if (!files) return;
    // const localFiles = localStorage.getItem(files);
    // if (localFiles) {
    //   files = localFiles.contact(files);
    // }
    // localStorage.setItem('files', files);
    for (var i = 0; i < files.length; i++) {
      const file = files[i];
      const imageType = /^image\//;

      if (!imageType.test(file.type)) {
        continue;
      }
      // 填充选择的图片到展示区
      const img = document.createElement('img');
      img.classList.add('obj');
      img.file = file;
      var preview = document.getElementById('preview');
      if (this.state.showArea) {
        this.setState({
          showArea: false
        });
      }
      preview.appendChild(img);
      // 读取File对象中的内容
      const reader = new FileReader();
      reader.onload = (function(aImg) {
        return function(e) {
          aImg.src = e.target.result;
        };
      })(img);
      reader.readAsDataURL(file);
    }
  }
  filesInput = e => {
    const files = e.target.files;
    this.readFileSize(files);
    this.previewFiles(files);
  }
  upload= () => {
    const file = document.getElementById('fileInput').files[0];
    var url = 'http://localhost:8080/';
    var form = new FormData();
    form.append('file', file);
    if (file) {
      const reader = new FileReader();
      const xhr = new XMLHttpRequest();
      xhr.onprogress = e => {
        // progress进度条
        const percentage = Math.round((e.loaded * 100) / e.total);
        console.log('percentage:' + percentage);
      };
      xhr.onload = e => {
        console.log('percentage:100' + e);
      };
      xhr.open('POST', url, true);
      reader.onload = e =>{
        xhr.send(e.target.result);
      };
      reader.readAsBinaryString(file);
    }
    // 服务器读取
    // 今天要写开题报告，这种瞎编的事没有思路啊，明明几句话可以搞定偏偏要凑那么多字 来来去去 还是写代码最得心应手 借此逃避 不好
  }
  render() {
    return (
      <div>
        <div className="filePicker">
          <label>点击选择文件</label>
          <input id="fileInput" type="file" name="file" multiple="multiple" accept="image/*"
            onChange={this.filesInput}/>
        </div>
        <div id="dropbox" className="dropbox" onDragEnter={e => this.dragEnter(e)} onDragOver={e => this.dragOver(e)} onDrop={e => this.drop(e)}>
          {this.state.showArea && <div className="area"></div>}
          <div id="preview"></div>
        </div>
        <div className="upload" onClick={this.upload}>点击上传</div>
      </div>
    );
  }
}
