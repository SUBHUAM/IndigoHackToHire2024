import React from 'react'
import AdminPanel from './admin/AdminPanel'
import Header from './components/Header'
import Users from './Users/Users'
import flight from './icons/flight.png'

function IndigoMain() {
  return (
    <div>
    <Header />
    <AdminPanel/>
    <div className='flex justify-center pt-16'>
    <img src={flight} height={135} width={135} alt="indigo icon"></img>
    </div>
    <Users/>
    {/* <Notification /> */}
    </div>
  )
}

export default IndigoMain