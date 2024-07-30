import React from 'react'
import Notification from './notifications/Notification'
import AdminPanel from './admin/AdminPanel'
import Header from './components/Header'
import Users from './Users/Users'

function IndigoMain() {
  return (
    <div>
    <Header />
    <AdminPanel/>
    <Users/>
    {/* <Notification /> */}
    </div>
  )
}

export default IndigoMain