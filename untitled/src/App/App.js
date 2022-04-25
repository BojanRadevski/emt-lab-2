import {Component} from "react";
import Service from "../repository/repository";
import Header from "../Header/header"
import {Navigate, Route, Routes} from "react-router-dom";
import Authors from "../Authors/authors"
import Author from "../Authors/authors"
import Books from "../Books/books"
import Countries from "../Countries/countries"
import Categories from "../Categories/categories"
import EditBook from "../Books/EditBook/edit-book"
import AddBook from "../Books/AddBook/add-book"


class App extends Component{
    constructor(props) {
        super(props);
        this.state={
            authors:[],
            books:[],
            categories:[],
            countries:[],
            selectedBook:{}
        }
    }

    render() {
        return(
    <div>
        <Header/>
        <div className="container">
            <Routes>
                <Route path={"/authors"} exact element={<Authors authors={this.state.authors}/>}></Route>
                <Route path={"/categories"} exact element={<Categories categories={this.state.categories}/>}></Route>
                <Route path={"/countries"} exact element={<Countries countries={this.state.countries}/>}></Route>

                <Route path={"/books/add"} exact element={<AddBook categories={this.state.categories} authors={this.state.authors} countries={this.state.countries} onAdd={this.addBook}/>}></Route>
                <Route path={"/books/edit/:id"} exact element={<EditBook categories={this.state.categories} authors={this.state.authors} onEditBook={this.editBook} book={this.state.selectedBook}/>}></Route>
                <Route path={"/books"} exact element={<Books books={this.state.books} onDelete={this.deleteBook} markAsTaken={this.markAsTaken} onEdit={this.getBook}/>}></Route>

                <Route path={"/"} element={<Navigate to={"/books"}/>}></Route>
            </Routes>

        </div>
    </div>
        );
    }

    deleteBook = (id) => {
        Service.deleteBook(id).then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, author, availableCopies) => {
        Service.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    editBook = (id, name, category, author, availableCopies) => {
        Service.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        Service.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    markAsTaken = (id) => {
        Service.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }

    loadAuthors=()=> {
        Service.fetchAuthors().then((data)=>{
                this.setState({
                    authors: data.data
                })
            });
    }
    loadBooks=()=>{
        Service.fetchBooks().then((data)=>{
            this.setState({
                books:data.data
            })
        })
    }
    loadCountries=()=>{
        Service.fetchCountries().then((data)=>{
            this.setState({
                countries:data.data
            })
        })
    }
    loadCategories=()=>{
        Service.fetchCategories().then((data)=>{
            this.setState({
                categories:data.data
            })
        })
    }

    deleteBook=(id)=>{
      Service.deleteBook(id).then(()=>{
            this.loadBooks();
      })
    }
    addBook=(name, category, author, availableCopies)=>{
        Service.addBook(name, category, author, availableCopies).then(()=>{
            this.loadBooks();
        })
    }
    editBook = (id, name, category, author, availableCopies) => {
        Service.editBook(id, name, category, author, availableCopies).then(() => {
                this.loadBooks();
            });
    }
    markAsTaken = (id) => {
        Service.markAsTaken(id).then(() => {
                this.loadBooks();
            });
    }
    getBook = (id) => {
        Service.getBook(id).then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }




    componentDidMount() {
        this.loadAuthors();
        this.loadBooks();
        this.loadCategories();
        this.loadCountries();
    }
}

export default App;