import React from 'react';
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Link
} from 'react-router-dom';

import PullView from '../carousel';


const Home = () => (
  <Router>
    <div>
      <h1>App</h1>
      <ul>
        <li><Link to="/PullView">PullView</Link></li>
      </ul>
      <Route path="/PullView" component={PullView} />
    </div>
  </Router>
)

export default Home