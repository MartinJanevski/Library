import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Categories from '../Categories/categories';
import Books from '../Books/BooksList/books'
import Header from '../Header/header';
import LibraryService from "../../repository/libraryRepository";

import BookEdit from '../Books/BookEdit/bookEdit';
import BookAdd from '../Books/BookAdd/bookAdd';                             

import AuthorAdd from '../Books/AuthorAdd/authorAdd';
import CountryAdd from '../Books/CountryAdd/countryAdd';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      booksList: [],
      categories: [],
      authors:[],
      countries:[],
      selectedProduct: {}
    }
  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/categories"} exact render={() =>
                  <Categories categories={this.state.categories}/>}/>
              <Route path={"/book/add"} exact render={() =>
                  <BookAdd categories={this.state.categories}
                            authors={this.state.authors}                              
                              onAddBook={this.addBook}/>}/>
              <Route path={"/book/addAuthor"} exact render={() =>
                  <AuthorAdd categories={this.state.categories}
                  countries={this.state.countries}                              
                              onAddAuthor={this.addAuthor}/>}/>
              <Route path={"/book/addCountry"} exact render={() =>
                  <CountryAdd                               
                              onAddCountry={this.addCountry}/>}/>
              <Route path={"/book/edit/:id"} exact render={() =>
                  <BookEdit categories={this.state.categories}                               
                               onEditProduct={this.editProduct}
                               product={this.state.selectedProduct}/>}/>
              <Route path={"/books"} exact render={() =>
                  <Books booksList={this.state.booksList}
                            onDelete={this.deleteBook}
                            onEdit={this.editBook}
                            onMarkAsTaken={this.markAsTaken}
                            />}/>
              <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadCategories();
    this.loadBooks();
    this.loadAuthors();
    this.loadCountry();
  }



  loadBooks = () => {
    LibraryService.fetchBooks()
        .then((data) => {
          this.setState({
            booksList: data.data
          })
        });
  }

  loadAuthors = () => {
    LibraryService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }
  loadCountry = () => {
    debugger;
    LibraryService.fetchCountries()
        .then((data) => {
          this.setState({
            countries: data.data
          })
        });
  }

  loadCategories = () => {
    LibraryService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  markAsTaken = (id) => {
    LibraryService.markAsTaken(id)
        .then(() => {
          this.loadBooks();
        });
  }

  deleteBook = (id) => {
    LibraryService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  editBook = (id) => {
    LibraryService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (authorId,  availableCopies, category,name) => {
    debugger;
    LibraryService.addBook(authorId,  availableCopies, category,name)
        .then(() => {
          this.loadBooks();
        });
  }

  addCountry= (continent, name)=>{
    LibraryService.addCountry(name, continent)
    .then(() => {
      this.loadBooks();
    });
  }

  addAuthor= (countryId, name, surname)=>{
    LibraryService.addAuthor(countryId, name,surname)
    .then(() => {
      this.loadBooks();
    });
  }




  getProduct = (id) => {
    LibraryService.getProduct(id)
        .then((data) => {
          this.setState({
            selectedProduct: data.data
          })
        })
  }

  editProduct = (id, name, price, quantity, category, manufacturer) => {
    LibraryService.editProduct(id, name, price, quantity, category, manufacturer)
        .then(() => {
          this.loadBooks();
        });
  }
}

export default App;
