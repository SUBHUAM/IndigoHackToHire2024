import './App.css';
import IndigoMain from './IndigoMain';
import { ChakraProvider } from '@chakra-ui/react'


function App() {
  return (
    <ChakraProvider>
    <div className="App background">
    <IndigoMain />
    </div>
    </ChakraProvider>

  );
}

export default App;
