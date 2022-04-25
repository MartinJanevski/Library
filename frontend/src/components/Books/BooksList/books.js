import React from 'react';
import {Link} from 'react-router-dom';

const books = (props) => {
    
    const deleteBook = (id) => {
        debugger;
        props.onDelete(id);
      }

      const markAsTaken = (id) => {
        debugger;
        props.onMarkAsTaken(id);
      }

  

   

    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Available Copies</th>
                            <th scope={"col"}>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.booksList.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.author.name}</td>
                                    <td>{term.category}</td>
                                    <td>{term.availableCopies}</td>
                                    <td className={" btn btn-group d-flex justify-content-end "}> 
                                        <Link className={"btn  btn-dark"} onClick={() => markAsTaken(term.id)}>Mark as taken</Link>
                                        <Link className={"btn  btn-dark"}  to= {    `/book/addCountry/${term.id}`}>Edit</Link>
                                        <Link className={"btn  btn-dark"} onClick={() => deleteBook(term.id)}>Delete</Link> 
                                    </td>
                                </tr>
                            );
                        })}
                        </tbody>
                      
                    </table>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/book/add"}>Add new book</Link>
                        </div>
                    </div>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/book/addAuthor"}>Add new author</Link>
                        </div>
                    </div>
                </div>   <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className={"btn btn-block btn-dark"} to={"/book/addCountry"}>Add new country</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default books;