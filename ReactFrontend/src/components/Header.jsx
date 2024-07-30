import React from 'react'

import indigoSvg from '../icons/indigo.png'
import Clock from './Clock';

function Header() {


  return (
    <div className='flex justify-center pt-6'>
    <div className=' w-2/3  bg-cyan-200 rounded-xl py-3 shadow-md'>
    <div className='flex px-6 justify-between items-center jus'>
     <img src={indigoSvg} height={150} width={150} alt='indigo icon'></img>
     
     <div className=''><Clock/></div>
     </div>
    </div>
    </div>
  )
}

export default Header