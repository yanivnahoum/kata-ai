import { greet } from '../index';

describe('greet', () => {
    it('should log "Hello, World!"', () => {
        const consoleSpy = jest.spyOn(console, 'log').mockImplementation();
        greet();
        expect(consoleSpy).toHaveBeenCalledWith('Hello, World!');
        consoleSpy.mockRestore();
    });
});